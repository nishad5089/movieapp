import { PageCriteria } from "src/app/core/interface/page-criteria";

export interface MovieFilter {
  pagination: PageCriteria
  filters: {
    title: string,
    releaseYear: Number
  }
}
