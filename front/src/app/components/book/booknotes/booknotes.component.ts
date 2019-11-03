import { Component, OnInit, ViewChild, DoCheck } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatMenuTrigger } from '@angular/material';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Router } from '@angular/router';
import { BookInfoService } from '../../book-info.service';

@Component({
  selector: 'app-book',
  templateUrl: './booknotes.component.html',
  styleUrls: ['./booknotes.component.css'],
  
})
export class BookNotesComponent implements OnInit,  DoCheck {
  @ViewChild('matMenuTrigger') mainMenu: MatMenuTrigger;

  bookInfoFormGroup: FormGroup;
  bookInfo: any;
  groupId:any;
  newBookInfo: any;
  isadd: boolean = false;
  headers: Headers;
  options: RequestOptions;
  groupBookinfolist: any[];
  arrow: String="keyboard_arrow_down";
  typesOfModule: String[]=["ceshi", "lishi", "hehe","budong","qiguai"];
  precent: number[] = new Array<number>();

  constructor(private http: Http, fb: FormBuilder,private router: Router, private bookInfoService: BookInfoService) {
    this.bookInfoFormGroup = fb.group({
      'name':'',
      'id' :'',
      'author':'',
      'price' : '',
      'groupid':'',
      'openflag':false
    }); 
    this.headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8' }); 
    this.options = new RequestOptions({ headers: this.headers });
    this.newBookInfo = {
      'name':'Lu bing xun',
      'id' :'1234',
      'author':'lishi',
      'price' : '23',
      'openflag':true
    };
    this.bookInfoService.getBookInfos().subscribe((res: Response) => {
      console.log(res.json())
      this.groupBookinfolist = res.json();
      console.log(res.json())
    });

  }

  setBookInfo(bookInfo: any){
    console.log("jinlai")
    console.log(bookInfo);
    console.log("jinlai1")
    this.isadd=false;
    this.bookInfo = bookInfo;
    this.groupId = bookInfo.id;
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
  
  addSubNode(){
    if(!this.bookInfo){
       this.groupId="######";
    }
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

  deleteNodes(){
    if(this.bookInfo){
      // console.log(this.bookInfo);
      return this.http.get("/api/deletebookinfo?id=" + this.bookInfo.id, this.options)
              .toPromise().then(response =>{
                console.log(response);
                this.refresh();
             }).catch(this.handleError);

    }else{
      alert("没有选中节点,无法删除.请先选择要删除的节点");
    }
  }

  refresh(){
    this.router.navigateByUrl("submit").then(responese => {
      console.log(responese);
      this.router.navigateByUrl("book");
    });
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

  ngDoCheck(){
    console.log("check");
  }
}
