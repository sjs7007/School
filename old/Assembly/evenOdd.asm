;code 2 : Check if given number is even or odd

data segment
msg db "Enter the number : $"
msg1 db 0ah,"Number is even$"
msg2 db 0ah,"Numebr is odd$"
;input db "$"
data ends

code segment
assume ds:data,cs:code
start:	mov ax,data
		mov ds,ax
		mov dx,offset msg
		mov ah,09h
		int 21h

up:		mov ah,01h
		int 21h
		mov[si],al
		inc si
		cmp al,0dh
		jnz up
		sub si,02h
		mov al,[si]
		ror al,01h ;rotate over right
		jnc odd
		mov dx,offset msg2

go: 	mov ah,09h
		int 21h
		mov ah,4ch
		int 21h

odd:	mov dx,offset msg1
		jmp go

code ends
end start