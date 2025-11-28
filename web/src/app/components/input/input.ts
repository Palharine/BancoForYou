import { Component, Input, forwardRef } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';
import { cn } from '@/lib/utils'; // sua função de concatenação de classes

@Component({
  selector: 'app-input',
  template: `
    <input
      [type]="type"
      [ngClass]="computedClass"
      [disabled]="disabled"
      [placeholder]="placeholder"
      [(ngModel)]="value"
    />
  `,
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => InputComponent),
      multi: true,
    },
  ],
})
export class InputComponent implements ControlValueAccessor {
  @Input() className: string = '';
  @Input() type: string = 'text';
  @Input() placeholder: string = '';
  @Input() disabled: boolean = false;

  value: string = '';

  // Computa as classes combinando o padrão + className passada
  get computedClass(): string {
    return cn(
      'flex h-9 w-full rounded-md border border-input bg-transparent px-3 py-1 text-sm shadow-xs transition-colors file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-ring disabled:cursor-not-allowed disabled:opacity-50',
      this.className
    );
  }

  // Métodos do ControlValueAccessor para ngModel
  onChange: any = () => {};
  onTouched: any = () => {};

  writeValue(value: any): void {
    this.value = value;
  }

  registerOnChange(fn: any): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }

  setDisabledState?(isDisabled: boolean): void {
    this.disabled = isDisabled;
  }
}

