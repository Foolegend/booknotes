import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatMenuTrigger } from '@angular/material';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Router } from '@angular/router';
import { BookInfoService } from '../book-info.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'],
  
})
export class BookComponent implements OnInit {
  @ViewChild('matMenuTrigger') mainMenu: MatMenuTrigger;

  myForm: FormGroup;
  bookInfo: any;
  newBookInfo: any;
  isadd: boolean = false;
  headers: Headers;
  options: RequestOptions;
  groupBookinfolist: any[];
  isOpen: boolean = true;
  isGroupOpen: Boolean[] = new Array<Boolean>();
  arrow: String="keyboard_arrow_down";
  arrowGroup: String[] = new Array<String>();
  typesOfModule: String[]=["ceshi", "lishi", "hehe","budong","qiguai"];
  precent: number[] = new Array<number>();

  constructor(private http: Http, fb: FormBuilder,private router: Router, private bookInfoService: BookInfoService) {
    this.myForm = fb.group({
      'name':'',
      'id' :'',
      'author':'',
      'price' : ''
    }); 
    this.headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8' }); 
    this.options = new RequestOptions({ headers: this.headers });
    this.newBookInfo = {
      'name':'Lu bing xun',
      'id' :'1234',
      'author':'lishi',
      'price' : '23'
    };
    this.bookInfoService.getBookInfos().subscribe((res: Response) => {
      console.log(res.json())
      this.groupBookinfolist = res.json();
      console.log(res.json())
      for(var i = 0; i < this.groupBookinfolist.length; i++){
        this.arrowGroup[i] = "keyboard_arrow_down";
        this.isGroupOpen[i] = true;
      }
    });

  }

  setBookInfo(bookInfo: any){
    this.isadd=false;
    this.bookInfo = bookInfo;
  }


  ngOnInit() {
  }

  modifyBookInfo(value: any){
    console.log(value);
    return this.http.post("/api/modifybookinfo", value, this.options)
            .toPromise().then(response =>{
               console.log(response);
               this.refresh();
              }).catch(this.handleError);
            
  }

  private handleError(error: any): Promise<any> { 
    console.error('An error occurred', error); 
    return Promise.reject(error.message || error); 
  } 

  openContextMenu(event) {
    console.log("woshi")
    event.preventDefault(); // Suppress the browser's context menu
    this.mainMenu.openMenu(); // Open your custom context menu instead
  }
  
  add(){
    this.isadd = true;
  }

  addBookInfo(value: any){
    console.log(value);
    return this.http.post("/api/addbookinfo", value, this.options)
            .toPromise().then(response =>{
              console.log(response);
              this.refresh();
           }).catch(this.handleError);
  }

  deleteBookInfo(value: String){
    console.log(value);
    return this.http.get("/api/deletebookinfo?id=" + value, this.options)
            .toPromise().then(response =>{
              console.log(response);
              this.refresh();
           }).catch(this.handleError);
  }

  refresh(){
    this.router.navigateByUrl("submit").then(responese => {
      console.log(responese);
      this.router.navigateByUrl("book");
    });
  }

  changeOpen(){
    this.isOpen = !this.isOpen;
    if(this.isOpen){
      this.arrow = "keyboard_arrow_down";
    }else{
      this.arrow = "keyboard_arrow_right";
    }
  }

  changeGroupOpen(i: any){
    this.isGroupOpen[i] = !this.isGroupOpen[i];
    if(this.isGroupOpen[i]){
      this.arrowGroup[i] = "keyboard_arrow_down";
    }else{
      this.arrowGroup[i] = "keyboard_arrow_right";
    }
  }

  getShowPercent(i : any){
    var per = this.precent[i];
  
    if(per){
      return per;
    }
    console.log("per=" + per + ",i=" + i)
    return 0;
  }
  getCircleSubtitle(i:any){
    if(this.precent[i] == 100){
      return "下载成功."
    }else{
      return this.typesOfModule[i];
    }
  }
  process(i:any){
    this.precent[i]=0;
    for(var k=0; k<100; k++){
      for(var j=0; j < 100; j++){
        console.log(j)
      }
      this.precent[i]=this.precent[i] + 1;
    } 
  }
}
