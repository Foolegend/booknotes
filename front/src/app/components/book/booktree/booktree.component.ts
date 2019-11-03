import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-booktree',
  templateUrl: './booktree.component.html',
  styleUrls: ['./booktree.component.css']
})
export class BooktreeComponent implements OnInit {
  @Input() bookinfolist: any;
  @Output() outBookInfo = new EventEmitter<any>();
  constructor() { }

  ngOnInit() {
  }

    // 点击动作
    itemClick(bookInfo: any) {
      // console.log("tree1");
      // console.log(bookInfo);
      // console.log("tree2");
      this.outBookInfo.emit(bookInfo);
    }

    //展开或折叠菜单
    changeOpen(bookinfo: any){
      if(bookinfo){
        bookinfo.openflag = !bookinfo.openflag;
        var books :any[];
        books = bookinfo.bookInfos;
        // console.log(books);
        if(books && books.length > 0){
          // console.log(books);
          for(let book  of books){
            // console.log("kk")
            // console.log(book)
            book.openflag = !book.openflag;
            this.changeOpen(book);
          }
        }
      }
    }
}
