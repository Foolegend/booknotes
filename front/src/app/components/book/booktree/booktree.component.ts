import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-booktree',
  templateUrl: './booktree.component.html',
  styleUrls: ['./booktree.component.css']
})
export class BooktreeComponent implements OnInit {
  @Input() bookinfolist: any;
  constructor() { }

  ngOnInit() {
  }

    // 点击动作
    itemClick(i) {
      // 建立一个服务来接收这个值, 或者借助双向绑定, 处理动作
      i._open = i._open  // 本例只简单演示开关, 借助 treelists本身实现
      console.log(i)
    }
}
