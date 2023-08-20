import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { GenreListComponent } from './components/genre-list/genre-list.component';
import { GenreComponent } from './genre.component';

const routes: Routes = [
  {
    path: '',
    component: GenreComponent,
    children: [
      {
        path: 'list',
        component: GenreListComponent,
      },

    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GenreRoutingModule { }
