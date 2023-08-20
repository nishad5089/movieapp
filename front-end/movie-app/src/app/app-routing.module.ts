import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LayoutComponent } from './layout/layout.component';
import { NotFoundComponent } from './page/not-found/not-found.component';
import { ErrorComponent } from './page/error/error.component';
import { SelectivePreloadingStrategy } from './core/preloading-strategy/selective-preloading-strategy';

export const routes: Routes = [
  {
    path: '',
    redirectTo: '/',
    pathMatch: 'full'
  },
  {
    path: 'error',
    component: ErrorComponent,
    data: {
      title: 'Error'
    }
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      // {
      //   path: 'dashboard',
      //   loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule),
      //   data: {
      //     preload: true,
      //   }
      // },

      {
        path: 'movie',
        loadChildren: () => import( './movie/movie.module').then(m => m.MovieModule),
        data: {
        }
      },

      {
        path: 'genre',
        loadChildren: () => import( './genre/genre.module').then(m => m.GenreModule),
        data: {
        }
      },
    ],

  },
  {
    path: '**',
    component: NotFoundComponent,
    data: {
      title: 'Not Found'
    }
  }

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes,
      {
        //enableTracing: true, // <-- debugging purposes only
        preloadingStrategy: SelectivePreloadingStrategy
      })
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
