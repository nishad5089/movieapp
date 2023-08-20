import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { NzMessageService } from 'ng-zorro-antd/message';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.less'],
  encapsulation: ViewEncapsulation.Emulated
})
export class SidebarComponent implements OnInit {

  @Input() isCollapsed = false;
  constructor(public messageService: NzMessageService) {
  }

  ngOnInit() {
  }

}
