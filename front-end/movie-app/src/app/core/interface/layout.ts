export interface Layout {
  fixed: boolean;
  collapsed: boolean;
  boxed: boolean;
  lang: string | null;
  theme: string | null;
  [key: string]: any;
}
