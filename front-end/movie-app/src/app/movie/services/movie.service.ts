import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Movie } from '../models/movie';
import { PagedApiResponse } from '../../core/interface/paged-api.response';
import { ApiResponse } from 'src/app/core/interface/api.response';
import { MovieFilter } from '../models/movie-filter';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private resourceUrl = `api/movie`;

  constructor(private http: HttpClient) { }

  get(id: number): Observable<ApiResponse<Movie>> {
    return this.http.get<ApiResponse<Movie>>(`${this.resourceUrl}/get/${id}`);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.resourceUrl}/delete/${id}`);
  }

  getAll(criteria: MovieFilter): Observable<PagedApiResponse<Movie>> {
    return this.http.post<PagedApiResponse<Movie>>(`${this.resourceUrl}/get/all`, criteria);
  }

  create(Movie: Movie): Observable<any> {
    return this.http.post(`${this.resourceUrl}/create`, Movie);
  }

  update(Movie: Movie): Observable<any> {
    return this.http.put(`${this.resourceUrl}/update`, Movie);
  }

}
