import { NzMessageService } from 'ng-zorro-antd/message';
import { MovieService } from '../../services/movie.service';
import { Router } from '@angular/router';
import { NzSelectSizeType } from 'ng-zorro-antd/select';

import { Component } from '@angular/core';
import { FormBuilder, FormGroup, UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, ValidationErrors, Validators } from '@angular/forms';
import { GenreService } from 'src/app/genre/service/genre.service';
import { Genre } from 'src/app/genre/models/genre';

@Component({
  selector: 'app-movie-add',
  templateUrl: './movie-add.component.html',
  styleUrls: ['./movie-add.component.less']
})
export class MovieAddComponent {
  form!: FormGroup;
  loading = false;
  submitting = false;
  failed = false;
  genres!: Genre[];

  constructor(private fb: FormBuilder,
    private msg: NzMessageService,
    private movieService: MovieService,
    private genreService: GenreService,
    private router: Router) {

    this.form = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(100)]],
      description: ['', [Validators.required,Validators.minLength(5),Validators.maxLength(300)]],
      releaseYear: ['', [Validators.required,]],
      genres: [[], []]
    });
  }
  size: NzSelectSizeType = 'default';

  ngOnInit(): void {
    this.getAllGenre();
  }

  submit(): void {
    if (this.form.valid) {
      this.loading = true;
      this.failed = false;
      this.movieService.create(this.form.value).subscribe(
        (data) => {
          this.loading = false;
          this.submitting = false;
          this.msg.success('Movie added successfully');
          console.log(data);
          this.form.reset();
          this.router.navigate(['/movie/list']);
        },
        (error) => {
          this.loading = false;
          this.failed = true;
        }
      );
    }

  }

  generateYearList(): number[] {
    const currentYear = new Date().getFullYear();
    const yearList = [];

    for (let year = currentYear; year >= currentYear - 100; year--) {
      yearList.push(year);
    }
    return yearList;
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
}
