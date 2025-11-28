import { Component, OnInit } from '@angular/core';
import { Historico } from '../../pages/historico/historico.ts';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html'
})
export class UserComponents implements OnInit {
 usuarios: any[] = []; // variável que vai armazenar a lista

  constructor(private historico: Historico) {}

  ngOnInit(): void {
    this.loadUsuarios();
  }

  loadUsuarios(): void {
      this.historico.findAll().subscribe(
      (data) => {
        this.usuarios = data; // recebe os dados do backend!
      },
      (error) => {
        console.error('Erro ao carregar usuários', error);
      }
    );
  }
}
