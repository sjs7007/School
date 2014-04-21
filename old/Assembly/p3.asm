;even odd - Done
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

inputDigit:
	mov ah,01h
	int 21h
	mov [si],al
	inc si
	cmp al,0dh
	jnz inputDigit
	mov al,[si-2]
	ror al,01h
	jnc evens
	jmp odd

evens:
	mov dx,offset msg2
	jmp display

odd:
	mov dx,offset msg3
	jmp display

display:
	mov ah,09h
	int 21h

	mov ah,4ch
	int 21h

code ends 
end start