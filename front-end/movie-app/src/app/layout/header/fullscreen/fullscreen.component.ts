import { Component, HostListener, OnInit } from '@angular/core';
import screenfull from 'screenfull';

@Component({
  selector: 'app-fullscreen',
  templateUrl: './fullscreen.component.html',
  styleUrls: ['./fullscreen.component.less']
})
export class FullscreenComponent implements OnInit {

  status = false;

  constructor() { }

  ngOnInit() {
  }

  toggle() {
    if (screenfull.isEnabled) {
      screenfull.toggle();
    }
    this.status = !screenfull.isFullscreen;
  }

  @HostListener('window:resize')
  _resize() {
    this.status = screenfull.isFullscreen;
  }

  @HostListener('click')
  _click() {
    if (screenfull.isEnabled) {
      screenfull.toggle();
    }
  }
}
