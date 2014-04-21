;sorting - done
data segment
msg1 db 0dh,0ah,"Enter Number : $"
msg2 db 0dh,0ah,"Sorted : $"
space db " $"
array db 10 dup("$")
data ends

code segment
assume cs:code,ds:data
start:
	mov ax,data
	mov ds,ax

	mov cx,0ah
	mov bx,00h

inputNumber:
	mov dx,offset msg1
	mov ah,09h
	int 21h

	mov ah,01h
	int 21h
	mov [array+bx],al
	inc bx
	cmp bx,0ah
	jnz inputNumber

loop1:
	mov bx,00h

loop2:
	mov al,[array+bx]
	cmp al,[array+bx+1]
	jge above

cont:
	inc bx
	cmp bx,09h
	jnz loop2
	dec cx
	jnz loop1
	jmp last

above:
	mov al,[array+bx]
	xchg al,[array+bx+1]
	mov [array+bx],al
	jmp cont

last:
	mov bx,00h
	mov dx,offset msg2
	mov ah,09h
	int 21h

display:
	mov dl,[array+bx]
	mov ah,02h
	int 21h

	mov dx,offset space
	mov ah,09h
	int 21h

	inc bx
	cmp bx,0ah
	jnz display

	mov ah,4ch
	int 21h

code ends 
end start