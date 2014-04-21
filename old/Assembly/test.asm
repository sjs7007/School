;sort array

data segment
msg1 db 0dh,0ah,"msg1 : $"
msg2 db 0dh,0ah,"msg2 : $"
array db 10 dup("$")
space db " $"
data ends

code segment
assume cs:code,ds:data
start:
	mov ax,data
	mov ds,ax

	mov cx,0ah
	mov bx,00h

inputNumbers:
	mov dx,offset msg1
	mov ah,09h
	int 21h

	mov ah,01h
	int 21h
	mov [array+bx],al
	inc bx
	cmp bx,0ah
	jnz inputNumbers

loop1:
	mov bx,00h

loop2:
	mov al,[array+bx]
	cmp al,[array+bx+1]
	jge greater

cont:
	inc bx
	cmp bx,09h
	jnz loop2
	dec cx
	jnz loop1
	jmp last
	
greater:
	mov al,[array+bx]
	xchg al,[array+bx+1]
	mov [array+bx],al
	jmp cont

last:
	mov bx,00h
	mov dx,offset msg2
	mov ah,09h
	int 21h

displayLoop:
	mov dl,[array+bx]
	mov ah,02h
	int 21h

	mov dx,offset space
	mov ah,09h
	int 21h

	inc bx
	cmp bx,0ah
	jnz displayLoop

	mov ah,4ch
	int 21h

code ends 
end start