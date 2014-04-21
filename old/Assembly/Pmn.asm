data segment
msg0 db 0dh,0ah,"Enter number : $"
msg1 db 0ah,"Max. of numbers is : $"
data ends

code segment
;assume cs:code,ds:data
start:	mov ax,data
	mov ds,ax
	
	mov si,6000h
	mov [si],0h
	mov cl,0ah; counter for 10 numbers

ip:	mov dx,offset msg0 ; display message and input number
	mov ah,09h
	int 21h
	mov ah,01h
	int 21h
	cmp al,byte ptr[si]
	jge greaters

checkEnd:dec cl
	cmp cl,00h
	jnz ip
	jmp ending

greaters:mov [si],al
	jmp checkEnd

ending:	mov dx,offset msg1
	mov ah,09h
	int 21h

	mov bx,[si]
	mov dx,bx
	mov ah,02h
	int 21h
	mov ah,4ch
	int 21h	

code ends
end start	
