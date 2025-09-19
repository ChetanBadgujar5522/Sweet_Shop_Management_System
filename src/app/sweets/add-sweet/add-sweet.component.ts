import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { SweetService } from '../sweet.service';

@Component({
  selector: 'app-add-sweet',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './add-sweet.component.html',
  styleUrls: ['./add-sweet.component.css']
})
export class AddSweetComponent {
  form: any; // declare the form variable

  constructor(private fb: FormBuilder, private svc: SweetService, private router: Router) {
    // Initialize the form here
    this.form = this.fb.group({
      name: ['', Validators.required],
      category: ['', Validators.required],
      price: [0, Validators.required],
      quantity: [0, Validators.required]
    });
  }

  submit() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.svc.create(this.form.value).subscribe(() => this.router.navigateByUrl('/'));
  }
}
