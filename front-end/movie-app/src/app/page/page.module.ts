import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';

import { ErrorComponent } from './error/error.component';
import { NotFoundComponent } from './not-found/not-found.component';

@NgModule({
  imports: [
    SharedModule
  ],
  declarations: [
    ErrorComponent,
    NotFoundComponent
  ]
})
export class PageModule {
}
