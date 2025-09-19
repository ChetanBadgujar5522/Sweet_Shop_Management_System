import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { tap } from 'rxjs/operators';
import { JwtHelperService } from './jwt-helper.service';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private base = `${environment.apiUrl}/auth`;

  constructor(private http: HttpClient) {}

  login(credentials: any) {
    return this.http.post<{ token: string }>(`${this.base}/login`, credentials)
      .pipe(tap(res => localStorage.setItem('token', res.token)));
  }

  register(credentials: any) {
    return this.http.post<{ token: string }>(`${this.base}/register`, credentials)
      .pipe(tap(res => localStorage.setItem('token', res.token)));
  }

  logout() {
    localStorage.removeItem('token');
  }

  getToken() {
    return localStorage.getItem('token');
  }

  isLoggedIn() {
    return !!this.getToken();
  }

  isAdmin(): boolean {
    const token = this.getToken();
    if (!token) return false;
    const role = JwtHelperService.getRole(token);
    return role === 'ROLE_ADMIN';
  }
}
