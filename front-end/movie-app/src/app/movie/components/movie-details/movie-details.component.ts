import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../services/movie.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.less']
})
export class MovieDetailsComponent implements OnInit{
  movie: any = {
  };

  constructor(
    private movieService: MovieService,
    private route: ActivatedRoute,
    private message: NzMessageService
  ) {}
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      this.getMovie(id);
    });
  }

  getMovie(id: number) {
    this.movieService.get(id).subscribe((data)=>{
      this.movie = data.data;
    })
  }
}
