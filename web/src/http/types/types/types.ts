import { Component, OnInit } from '@angular/core';
import { HistoricoService } from '../../services/historico.service';

// Interface para tipagem do usuário
interface Usuario {
  id: number;
  nome: string;
  email: string;
  // adicione outros campos conforme o backend
}

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html'
})
export class UserComponents implements OnInit {
  usuarios: Usuario[] = [];

  constructor(private historicoService: HistoricoService) {}

  ngOnInit(): void {
    this.loadUsuarios();
  }

  loadUsuarios(): void {
    this.historicoService.findAll().subscribe(
      (data: Usuario[]) => {
        this.usuarios = data; // recebe os dados do backend
      },
      (error: any) => {
        console.error('Erro ao carregar usuários', error);
      }
    );
  }
}

