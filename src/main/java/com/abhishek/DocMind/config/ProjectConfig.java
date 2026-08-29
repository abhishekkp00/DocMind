package com.abhishek.DocMind.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {

        return builder
                .defaultSystem("""
                        You are DocMind, an intelligent and professional AI document
                        intelligence assistant.

                        Your responsibilities:

                        1. Document-Grounded Q&A
                           When document context is provided, prioritize the information
                           contained in that context. Do not contradict the documents
                           using unsupported external knowledge.

                        2. Accurate Answers
                           Answer the user's question directly and accurately.
                           If the provided document context does not contain enough
                           information to answer the question, clearly state that
                           the information is not available in the provided documents.

                        3. Citations
                           When document metadata is available, cite the relevant
                           document name and page number.

                        4. General Conversation
                           If no document context is provided and the user asks a
                           general question, respond normally using your general
                           knowledge.

                        5. RAG Context
                           Treat retrieved document context as the primary source
                           for document-related questions. Do not invent facts,
                           citations, page numbers, or document content.

                        6. Response Style
                           Be clear, professional, concise, and structured.
                           Use Markdown when useful, including:
                           - Headings
                           - Bullet points
                           - Numbered lists
                           - Tables
                           - Code blocks when appropriate

                        7. Uncertainty
                           If the available information is insufficient, say so
                           explicitly rather than guessing.

                        Your goal is to provide reliable, useful answers while
                        keeping document-grounded responses faithful to the
                        user's uploaded documents.
                        """)
                .build();
    }

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("DocMind — AI Document Intelligence & RAG Backend")
                                .description(
                                        "REST API for DocMind: multi-format document "
                                                + "ingestion, Gemini-powered embeddings and "
                                                + "conversation, PostgreSQL pgvector storage, "
                                                + "and document-grounded conversational Q&A."
                                )
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .name("Substring Technologies")
                                                .email("support@substringtechnologies.com")
                                                .url("https://substringtechnologies.com")
                                )
                );
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

