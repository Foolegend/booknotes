import { Component, OnInit } from '@angular/core';
import { BookInfoService } from '../book-info.service';
import {Response} from '@angular/http'

@Component({
  selector: 'app-price',
  templateUrl: './price.component.html',
  styleUrls: ['./price.component.css']
})
export class PriceComponent implements OnInit {
  bookInfo: any;
  groupBookinfolist: any[];
  isOpen: boolean = true;
  isGroupOpen: Boolean[] = new Array<Boolean>();
  arrow: String="keyboard_arrow_down";
  arrowGroup: String[] = new Array<String>();
  constructor(private bookInfoService: BookInfoService) { 
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

  ngOnInit() {
  }

  setBookInfo(bookInfo: any){
    this.bookInfo = bookInfo;
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
}
