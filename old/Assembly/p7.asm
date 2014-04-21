;bcd hex - Done

data segment
msg1 db 0dh,0ah,"Enter numbers : $"
msg2 db 0dh,0ah,"Hex. is : $"
abc dw ?
data ends

code segment
assume cs:code,ds:data
start:
	mov ax,data
	mov ds,ax

	mov dx,offset msg1
	mov ah,09h
	int 21h

inputDigit:
	mov ah,01h
	int 21h
	sub al,30h
	mov [si],al
	inc si
	add al,30h
	cmp al,0dh
	jnz inputDigit

extract:
	mov bl,[si-3]
	mov al,0ah
	mul bl
	mov dl,[si-2]
	mov dh,00h
	add ax,dx
	mov abc,ax

	mov dx,offset msg2
	mov ah,09h
	int 21h

	mov cl,04h
	mov ax,abc

loop1:
	mov dx,00h
	mov bx,10h
	div bx
	cmp dx,0ah
	jnae loop2
	add dx,07h

loop2:
	add dx,30h
	push dx
	dec cl
	jnz loop1
	mov cl,04h

display:
	pop dx
	mov ah,02h
	int 21h
	dec cl
	jnz display

	mov ah,4ch
	int 21h

code ends 
end start