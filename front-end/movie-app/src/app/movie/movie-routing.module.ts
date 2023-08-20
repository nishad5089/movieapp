import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MovieListComponent } from './components/movie-list/movie-list.component';
import { MovieAddComponent } from './components/movie-add/movie-add.component';
import { MovieDetailsComponent } from './components/movie-details/movie-details.component';
import { MovieComponent } from './movie.component';

const routes: Routes = [
  {
    path: '',
    component: MovieComponent,
    children: [
      {
        path: 'list',
        component: MovieListComponent,
      },
      {
        path: 'add',
        component: MovieAddComponent,
      },
      {
        path: 'details/:id',
        component: MovieDetailsComponent,
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MovieRoutingModule { }
