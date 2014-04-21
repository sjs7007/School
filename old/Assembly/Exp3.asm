;Even Odd Test : Done

data segment
msg1 db 0dh,0ah,"Enter number : $"
msg2 db 0dh,0ah,"Number is even.$"
msg3 db 0dh,0ah,"Number is odd.$"
data ends

code segment
assume cs:code,ds:data
start:
		mov ax,data
		mov ds,ax

		mov dx,offset msg1
		mov ah,09h
		int 21h

digitInput:		mov ah,01h
				int 21h
				mov [si],al
				inc si
				cmp al,0dh
				jnz digitInput
				sub si,02h
				mov al,[si]
				ror al,01h
				jc odd
				mov dx,offset msg2
				jmp ending

odd:	mov dx,offset msg3
		jmp ending

ending:	mov ah,09h
		int 21h

		mov ah,4ch
		int 21h

code ends
end start

