package com.petshop.services;

// Serviço para prover ao usuario logado no momento, e login automatico apos ter registrado uma conta
public interface SecurityService
{
	String findLoggedInUsername();
	void autologin(String username, String password);
}