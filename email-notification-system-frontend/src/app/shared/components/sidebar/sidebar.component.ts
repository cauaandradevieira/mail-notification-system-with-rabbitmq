import { Component, signal } from '@angular/core';
import { SidebarItem, SidebarItemComponent } from './sidebar-item/sidebar-item.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  imports: [SidebarItemComponent],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent 
{

  constructor(private router: Router) {}

  items = signal<SidebarItem[]>([
    { label: 'Dashboard', routerLink: '/dashboard', active: true, icon: "fa-solid fa-gauge"},
    { label: 'Email', routerLink: '/email' , active: false, icon: "fa-solid fa-envelope"},
    { label: 'Contact', routerLink: '/contact' , active: false, icon: "fa-solid fa-user"},
    { label: 'Contact Group', routerLink: '/group' , active: false, icon: "fa-solid fa-address-book"  }
  ]);

  public setActiveItem(itemName: string) {
    this.items.update(items => 
      items.map(item => ({
        ...item,
        active: item.label === itemName
      }))
    )
    
    const item = this.items().find(item => item.active);
    console.log(item);
    this.router.navigate([item?.routerLink]);
  }
}
