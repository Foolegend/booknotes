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
}
