import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class JwtHelperService {
  static parse(token: string): any {
    try {
      const payload = token.split('.')[1];
      const json = atob(payload.replace(/-/g, '+').replace(/_/g, '/'));
      return JSON.parse(decodeURIComponent(escape(json)));
    } catch (e) {
      return null;
    }
  }

  static getRole(token: string): string | null {
    const p = this.parse(token);
    return p ? p.role || null : null;
  }
}
