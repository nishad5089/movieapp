import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.less'],
  encapsulation: ViewEncapsulation.Emulated
})
export class LayoutComponent implements OnInit {

  isCollapsed = false;
  constructor() { }
  onCollapseChange(value: any) {
    this.isCollapsed = value;
  }

  ngOnInit(): void {
  }
}
