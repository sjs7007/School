data segment
msg0 db "Enter string : $"
msg1 db "String is a palindrome.$"
msg2 db "String is not a palindrome.$"
data ends

code segment
start:	mov ax,data
	mov ds,ax
	
	mov si,6000h
	mov di,2000h
	mov cl,00h

	mov dx,offset msg0
	mov ah,09h
	int 21h

up:	mov ah,01h
	int 21h
	mov [si],al
	mov [di],al
	inc si
	inc di
	inc cl
	cmp al,0dh
	jnz up

	mov si,6000h
	sub cl,01h
	sub di,02h

down:	mov al,[di]
	cmp al,[si]
	jnz notPal
	sub cl,01h
	sub di,01h
	inc si
	cmp cl,00h
	jnz down

pal:	mov dx,offset msg1
	jmp ending

notPal:	mov dx,offset msg2
	jmp ending

ending: mov ah,09h
	int 21h
	mov ah,4ch
	int 21h
`	
code ends
end start
