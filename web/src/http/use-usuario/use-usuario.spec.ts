import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UseUsuario } from './use-usuario';

describe('UseUsuario', () => {
  let component: UseUsuario;
  let fixture: ComponentFixture<UseUsuario>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UseUsuario]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UseUsuario);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
