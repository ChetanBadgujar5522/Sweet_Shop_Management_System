import { Component, OnInit } from '@angular/core';
import { SweetService } from '../sweet.service';
import { AuthService } from '../../auth/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sweet-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sweet-list.component.html',
  styleUrls: ['./sweet-list.component.css']
})
export class SweetListComponent implements OnInit {
  sweets: any[] = [];

  constructor(private svc: SweetService, public auth: AuthService) {}

  ngOnInit() {
    this.load();
  }

  load() {
    this.svc.list().subscribe(r => (this.sweets = r));
  }

  purchase(s: any) {
    this.svc.purchase(s.id, 1).subscribe(() => this.load(), err => alert(err.error || 'Error'));
  }

  restock(s: any) {
    const qty = Number(window.prompt('Qty to restock', '5')) || 0;
    if (qty > 0) {
      this.svc.restock(s.id, qty).subscribe(() => this.load());
    }
  }

  deleteSweet(s: any) {
    if (confirm('Delete?')) {
      this.svc.delete(s.id).subscribe(() => this.load());
    }
  }
}
