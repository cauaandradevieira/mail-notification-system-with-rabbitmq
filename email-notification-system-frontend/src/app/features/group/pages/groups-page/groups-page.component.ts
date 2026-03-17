import { Component, signal } from '@angular/core';
import { GroupService } from '../../service/group.service';
import { GroupResponse } from '../../interfaces/group-response';
import { ModalComponent } from '../../../../shared/components/modal/modal.component';


@Component({
  selector: 'app-groups-page',
  imports: [ModalComponent],
  templateUrl: './groups-page.component.html',
  styleUrl: './groups-page.component.css'
})
export class GroupsPageComponent {
  // group: name, descrição e color
  // atributo do tipo GroupData
  public groupResponse = signal<GroupResponse>({name: "", description: "", color: ""});
  public showModal = false;

  // constructor injetando GroupService 
  constructor (private groupService: GroupService){}

  // metodo ngOnInit para iniciar o metodo getAll()
  ngOnInit()
  {
    this.getAll();
  }

  // metodo para mostrar todos os groups com quantidade de contatos
  private getAll() : void
  {
    this.groupService.getAll().subscribe(
      {
        next: (group => this.groupResponse.set(group)),
        error: (error => console.log(error))
      }
    );
  }

  openModal() {
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
  }
  
}
