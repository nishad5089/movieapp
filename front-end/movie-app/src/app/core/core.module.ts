import { APP_INITIALIZER, InjectionToken, NgModule, Optional, SkipSelf } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { NgxWebstorageModule } from 'ngx-webstorage';


export const WINDOW = new InjectionToken('Window');

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    RouterModule,
    NgxWebstorageModule.forRoot({ prefix: 'app', separator: '-' })
  ],
  declarations: [

  ],
  providers: [

    { provide: WINDOW, useValue: window }
  ]
})
export class CoreModule {
  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error('CoreModule is already loaded. Import it in the AppModule only');
    }
  }
}
