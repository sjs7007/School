;11:45
data segment
msg1 db 0dh,0ah,"Enter number : $"
msg2 db 0dh,0ah,"Sorted numbers are : $"
array db 10 dup("$")
space db " $"
data ends

code segment
assume cs:code,ds:data
start:
	mov ax,data
	mov ds,ax

	mov cx,0ah; keep constant
	mov bx,00h

inputNumbers:
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
	jae greater

greater:
	mov al,[array+bx]
	xchg al,[array+bx+1]
	mov [array+bx],al
	jmp cont
	
cont:
	inc bx
	cmp bx,09h
	jnz loop2
	dec cx
	jnz loop1
	jmp last


last:
	mov bh,00h
	mov dx,offset msg2
	mov ah,09h
	int 21j

displayLoop:
	mov dl,[array+bx]
	mov ah,02h
	int 21h
	inc bx
	cmp bx,0ah
	jnz displayLoop

	mov ah,4ch
	int 21h

code ends
end start