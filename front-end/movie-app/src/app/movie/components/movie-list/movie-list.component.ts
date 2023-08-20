import { Component, OnInit } from '@angular/core';
import { MovieFilter } from '../../models/movie-filter';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MovieService } from '../../services/movie.service';
import { PagedApiResponse } from 'src/app/core/interface/paged-api.response';
import { Movie } from '../../models/movie';
import { NzMessageService } from 'ng-zorro-antd/message';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.less']
})

export class MovieListComponent implements OnInit {
  expandSet = new Set<number>();
  criteria: MovieFilter = <MovieFilter>{
    pagination: {
      page: 1,
      size: 5,
    },
    filters: {},
  };

  sorts = { key: 'id', value: 'descend' };

  validateForm!: FormGroup;
  loading = false;
  data!: PagedApiResponse<Movie>;

  constructor(
    private movieService: MovieService,
    private message: NzMessageService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.initializeForm();
    this.load();
  }

  initializeForm() {
    this.validateForm = this.fb.group({
      title: [null],
      releaseYear: [null],
    });
  }

  onExpandChange(id: number, checked: boolean): void {
    if (checked) {
      this.expandSet.add(id);
    } else {
      this.expandSet.delete(id);
    }
  }

  sort({ sort }: any) {
    const selectedSort = sort.find((item: any) => item.value);
    if (selectedSort) {
      this.sorts = selectedSort;
      this.load();
    }
  }

  load() {
    this.loading = true;
    const payload = this.createPayload();

    this.movieService.getAll(payload).subscribe(
      (data: PagedApiResponse<Movie>) => {
        this.loading = false;
        this.data = data;
      },
      (error: any) => {
        this.loading = false;
        this.message.error('Failed to load data.', error);
      }
    );
  }

  createPayload() {
    const { page, size } = this.criteria.pagination;
    const { key, value } = this.sorts;

    return {
      pagination: {
        page: page > 0 ? page : 1,
        size: size > 0 ? size : 5,
        sorts: [`${key},${value === 'ascend' ? 'asc' : 'desc'}`],
      },
      filters: { ...this.criteria.filters },
    };
  }
}
