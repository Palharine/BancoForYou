import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TransferenciaService } from '@/http/use-transacoes'; // seu serviço Angular para chamadas HTTP

@Component({
  selector: 'app-transferencia',
  templateUrl: './transferencia.component.html',
  styleUrls: ['./transferencia.component.scss'],
})
export class TransferenciaComponent implements OnInit {
  form: FormGroup;
  isPending: boolean = false;

  constructor(
    private fb: FormBuilder,
    private transferenciaService: TransferenciaService,
    private router: Router
  ) {
    this.form = this.fb.group({
      valor: ['', Validators.required],
      formaPagamento: ['PIX', Validators.required],
      tipoConta: ['corrente', Validators.required],
      chave: ['', Validators.required],
      paganteId: ['', Validators.required],
      receptanteId: ['', Validators.required],
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    this.isPending = true;

    const data = {
      ...this.form.value,
      valor: parseFloat(this.form.value.valor),
      data: new Date().toISOString(),
    };

    this.transferenciaService.transferir(data).subscribe({
      next: () => {
        alert('Transferência realizada com sucesso!');
        this.router.navigate(['/']);
      },
      error: (error) => {
        alert('Erro ao realizar transferência: ' + error.message);
      },
      complete: () => {
        this.isPending = false;
      },
    });
  }

  cancelar(): void {
    this.router.navigate(['/']);
  }
}

