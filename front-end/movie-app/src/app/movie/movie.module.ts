import { NgModule } from '@angular/core';

import { MovieAddComponent } from './components/movie-add/movie-add.component';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import { MovieDetailsComponent } from './components/movie-details/movie-details.component';
import { MovieComponent } from './movie.component';
import { SharedModule } from '../shared/shared.module';
import { MovieRoutingModule } from './movie-routing.module';

@NgModule({
  declarations: [
    MovieComponent,
    MovieAddComponent,
    MovieListComponent,
    MovieDetailsComponent
  ],
  imports: [
    SharedModule,
    MovieRoutingModule
  ]
})
export class MovieModule { }
