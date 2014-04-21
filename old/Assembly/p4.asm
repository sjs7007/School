;checkPal - Done

data segment
msg1 db 0dh,0ah,"Enter number : $"
msg2 db 0dh,0ah,"Palindrome.$"
msg3 db 0dh,0ah,"Not a palindrome.$"
data ends

code segment
assume cs:code,ds:data
start:
	mov ax,data
	mov ds,ax

	mov dx,offset msg1
	mov ah,09h
	int 21h

	mov si,6000h
	mov di,2000h
	mov cl,00h

inputDigit:
	mov ah,01h
	int 21h
	mov [si],al
	mov [di],al
	inc si
	inc di
	inc cl
	cmp al,0dh
	jnz inputDigit

	mov si,6000h
	dec cl
	sub di,02h

checkPal:
	mov bl,[si]
	cmp bl,[di]
	jnz notPal
	inc si
	dec di
	dec cl
	jz Pal
	jnz checkPal

Pal:
	mov dx,offset msg2
	jmp display

notPal:
	mov dx,offset msg3
	jmp display

display:
	mov ah,09h
	int 21h

	mov ah,4ch
	int 21h

code ends 
end start