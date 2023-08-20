import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';
import { GenreListComponent } from './components/genre-list/genre-list.component';
import { GenreRoutingModule } from './genre.routing';
import { GenreComponent } from './genre.component';

@NgModule({
  declarations: [
    GenreComponent,
    GenreListComponent
  ],
  imports: [
    SharedModule,
    GenreRoutingModule
  ]
})
export class GenreModule { }
