import { Component, OnInit } from '@angular/core';
import {ChatListComponent} from '../../components/chat-list/chat-list.component';
import {ChatService} from '../../services/services/chat.service';
import {ChatResponse} from '../../services/models/chat-response';

@Component({
  selector: 'app-main',
  imports: [
    ChatListComponent
  ],
  templateUrl: './main.component.html',
  styleUrl: './main.component.scss'
})
export class MainComponent implements OnInit {

  chats: Array<ChatResponse> = [] ;


  constructor(
    private chatService: ChatService
  ) {}

  ngOnInit(): void {

  this.getAllChats();
    }

    private getAllChats(): void {
    this.chatService.getChatsByReceiver()
      .subscribe({
        next:(res) => {
          this.chats = res;
        }
      })
    }

}
