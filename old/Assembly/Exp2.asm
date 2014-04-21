;Find max. of 10 nos. : Done

data segment
msg1 db 0dh,0ah,"Enter a number : $"
msg2 db 0dh,0ah,"Max. of numbers is : $"
data ends

code segment
assume cs:code,ds:data
start:	
		mov si,6000h
		mov [si],00h
		mov cl,0ah

		mov ax,data
		mov ds,ax

enterNumber:	dec cl
				mov dx,offset msg1
				mov ah,09h
				int 21h

				mov ah,01h
				int 21h
				cmp al,byte ptr[si]
				jge greater
				jmp checkCount

greater:		mov [si],al
				jmp checkCount

checkCount:		cmp cl,00h
				jz endDisplay
				jmp enterNumber

endDisplay:			
				mov dx,offset msg2
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