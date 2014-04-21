;Palindrome - Done

data segment
msg1 db 0dh,0ah,"Enter a string : $"
msg2 db 0dh,0ah,"Palindrome.$"
msg3 db 0dh,0ah,"Not a Palindrome.$"
data ends

code segment
assume cs:code,ds:data
start:	
		mov ax,data
		mov ds,ax

		mov si,6000h
		mov di,2000h
		mov cl,00h

		mov dx,offset msg1
		mov ah,09h
		int 21h

inputChar:
			mov ah,01h
			int 21h
			mov [si],al
			mov [di],al
			inc si
			inc di
			inc cl
			cmp al,0dh
			jnz inputChar
			
			mov si,6000h
			sub di,02h
			dec cl
			jmp PalCheck

PalCheck:	mov bl,[di]
			cmp [si],bl
			jnz notPal
			inc si
			dec di
			dec cl
			cmp cl,00h
			jz Pal
			jmp PalCheck

notPal:		mov dx,offset msg3
			jmp ending

Pal:		mov dx,offset msg2
			jmp ending

ending:		mov ah,09h
			int 21h
			mov ah,4ch
			int 21h

code ends
end start