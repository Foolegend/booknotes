import { Component, ViewChild } from '@angular/core';
import { MatMenuTrigger } from '@angular/material';

@Component({
  selector: 'contextmenu-example',
  template: `
    <span [matMenuTriggerFor]="contextMenu"></span>
    <button mat-button (contextmenu)="openContextMenu($event)">Context Menu</button>
    <mat-menu #contextMenu="matMenu" yPosition="below">
      <button mat-menu-item>Item 1</button>
      <button mat-menu-item>Item 2</button>
    </mat-menu>
  `,
})
export class Contextmenuexample {
  @ViewChild(MatMenuTrigger) contextMenu: MatMenuTrigger;

  openContextMenu(event) {
    event.preventDefault(); // Suppress the browser's context menu
    this.contextMenu.openMenu(); // Open your custom context menu instead
  }
}