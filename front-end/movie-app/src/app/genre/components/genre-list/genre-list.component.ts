import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { GenreService } from '../../service/genre.service';
import { Genre } from '../../models/genre';

@Component({
  selector: 'app-genre-list',
  templateUrl: './genre-list.component.html',
  styleUrls: ['./genre-list.component.less']
})
export class GenreListComponent {

  loading = false;
  genres!: Genre[];
  constructor(
    private msg: NzMessageService,
    private genreService: GenreService,
    private router: Router) {
  }

  getAllGenre() {
    this.genreService.getAll().subscribe(
      (data: any) => {
        this.loading = false;
        this.genres = data.data;
      },
      error => {
        this.loading = false;
        this.msg.error('Failed to load data.', error);
      }
    );
  }

  ngOnInit(): void {
    this.getAllGenre();
  }
}
