import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RouterLink } from "@angular/router";

export interface SidebarItem
{
  label: string,
  routerLink: string,
  active: boolean,
  icon: string
}

@Component({
  selector: 'app-sidebar-item',
  imports: [],
  templateUrl: './sidebar-item.component.html',
  styleUrl: './sidebar-item.component.css'
})
export class SidebarItemComponent {
  @Input() item!: SidebarItem;
  @Output() onClickedEmit = new EventEmitter<string>();
  
  onClicked()
  {
    this.onClickedEmit.emit(this.item.label);
    
  }
}
