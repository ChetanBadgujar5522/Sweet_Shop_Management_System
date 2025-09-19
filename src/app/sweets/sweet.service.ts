import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class SweetService {
  private base = `${environment.apiUrl}/sweets`;

  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<any[]>(this.base);
  }

  create(sweet: any) {
    return this.http.post(this.base, sweet);
  }

  update(id: number, sweet: any) {
    return this.http.put(`${this.base}/${id}`, sweet);
  }

  delete(id: number) {
    return this.http.delete(`${this.base}/${id}`);
  }

  purchase(id: number, qty = 1) {
    return this.http.post(`${this.base}/${id}/purchase?qty=${qty}`, {});
  }

  restock(id: number, qty = 1) {
    return this.http.post(`${this.base}/${id}/restock?qty=${qty}`, {});
  }

  search(params: any) {
    const p = new URLSearchParams();
    if (params.name) p.set('name', params.name);
    if (params.category) p.set('category', params.category);
    if (params.min) p.set('min', params.min);
    if (params.max) p.set('max', params.max);
    return this.http.get<any[]>(`${this.base}/search?${p.toString()}`);
  }
}
