;Exp 8 : Ascending sort

data segment
msg1 db 0dh,0ah,"Enter number : $"
msg2 db 0dh,0ah,"Sorted numbers are : $"
array db 10 dup("$")
space db " $"
data ends

code segment
assume cs:code,ds:data

start:
	mov ax,data ;tell which ds to use
	mov ds,ax

	mov cx,0ah ;counter value 10
	mov bx,00h

l1:		
	mov dx,offset msg1 ;display msg1
	mov ah,09h
	int 21h

	mov ah,01h ;input number and store in array
	int 21h
	;sub al,30h ;don't think this is needed 
	mov [array+bx],al
	inc bx
	dec cx

	;mov al,00h ;clear bits,don't think needed
	jnz l1
	mov cx,0ah

loop1:
	mov dx,09h ;why?
	mov bx,00h

loop2:
	mov al,[array+bx]
	cmp al,[array+bx+1]
	jae above

cont:
	inc bx
	dec dx
	jnz loop2
	dec cx
	jnz loop1
	jmp last

above:
	mov al,[array+bx+1]
	xchg [array+bx],al
	mov [array+bx+1],al
	jmp cont

last:
	mov cx,0ah
	mov bx,00h
	
	;display msg2
	mov dx,offset msg2
	mov ah,09h
	int 21h

	mov dx,00h

loop3:
	mov dl,[array+bx]
	;add dl,30h
	mov ah,02h
	int 21h
	mov dx,offset space
	mov ah,09h
	int 21h
	inc bx
	dec cx
	jnz loop3

	mov ah,4ch
	int 21h

code ends
end start




