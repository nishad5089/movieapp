import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { LayoutComponent } from './layout.component';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FullscreenComponent } from './header/fullscreen/fullscreen.component';

@NgModule({
  imports: [
    SharedModule
  ],
  declarations: [LayoutComponent, HeaderComponent, SidebarComponent, FullscreenComponent]
})
export class AppLayoutModule { }
